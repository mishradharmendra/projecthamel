/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.managedbeans;

import com.store.entities.Item;
import com.store.service.ItemRemote;
import com.store.util.Message;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import com.store.util.FileUtil;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import org.apache.myfaces.custom.fileupload.UploadedFile;

/**
 *
 * @author trana
 */
public class ItemManagedBean {

    @EJB
    private ItemRemote itemService;
    private Item item;
    private List<Item> itemList = null;
    private Message message;
    private UploadedFile uploadedFile;
    private String uploadFolder;

    public ItemManagedBean() throws IOException {
        Properties prop = new Properties();
        prop.load(getClass().getClassLoader().getResourceAsStream(
                "com/store/properties/server.properties"));
        this.uploadFolder = prop.getProperty("upload_path");
        System.out.println("Upload Path is: " + this.uploadFolder);
    }

    public String createItem() {
        this.item = new Item();
        return "item_create";
    }

    private void updloadImage() throws IOException, NullPointerException {
        String uploadedFileName = FileUtil.trimFilePath(uploadedFile.getName());
        File uniqueFile = FileUtil.uniqueFile(new File(this.getUploadFolder()), uploadedFileName);
        FileUtil.write(uniqueFile, uploadedFile.getInputStream());
        this.item.setImage(uniqueFile.getName());
    }

    public String create() {
        Item newItem = itemService.findItem(item.getBarcode());
        if (newItem != null) {
            message.addErrorMessage("This item already exists.");
            return "item_create";
        }
        try {
            try {
                updloadImage();
            } catch (IOException e) {
                message.addErrorMessage("File " + item.getImage() + " could not be uploaded!");
            } catch (NullPointerException ex) {
                message.addErrorMessage("No Image was provided");
                System.out.println("The image was not provided!.. Uploaded File Name is " + uploadedFile);
            }
            itemService.addItem(item);
            message.addSuccessMessage("New item was successfully submitted.");
        } catch (Exception ex) {
            message.addErrorMessage(ex.getLocalizedMessage());
        }
        return "items_view";
    }

    public String listItems() {
        return "items_view";
    }

    public String editItem() {
        int barcode = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("currentItemBarcode"));
        item = itemService.findItem(barcode);
        return "customer_edit";
    }

    public String edit() {
        try {
            updloadImage();
        } catch (IOException e) {
            message.addErrorMessage("File " + item.getImage() + " could not be uploaded!");

        } catch (NullPointerException ex) {
            message.addErrorMessage("No Image was not provided");
            System.out.println("The image was not provided!.. Uploaded File Name is " + uploadedFile);
        }
        try {
            itemService.updateItem(item.getId(), item.getName(), item.getQuantity(),
                    item.getPrice(), item.getBarcode(), item.getMinQuantity(), item.getImage());
            message.addSuccessMessage("This item has been updated successfully.");
        } catch (Exception ex) {
            message.addErrorMessage(ex.getLocalizedMessage());
        }

        return "items_view";
    }

    public String removeItem() {
        int id = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("currentItemID"));
        itemService.removeItem(id);
        return "item_remove";
    }

    /**
     * @return the item
     */
    public Item getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * @return the itemList
     */
    public List<Item> getItemList() {
        return itemService.findAllItems();
    }

    /**
     * @param itemList the customerList to set
     */
    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    /**
     * @return the uploadFolder
     */
    public String getUploadFolder() {
        return uploadFolder;
    }

    /**
     * @param uploadFolder the uploadFolder to set
     */
    public void setUploadFolder(String uploadFolder) {
        this.uploadFolder = uploadFolder;
    }

    /**
     * @return the uploadedFile
     */
    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    /**
     * @param uploadedFile the uploadFolder to set
     */
    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }
}
