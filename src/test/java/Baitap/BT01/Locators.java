package Baitap.BT01;

public class Locators {


    // Login
    public static String headerLogin = "//h1[normalize-space()='Login']";
    public static String inputEmail = "//input[@id='email']";
    public static String inputPassword = "//input[@id='password']";
    public static String checkBoxRememberMe = "//input[@id='remember']";
    public static String buttonLogin = "//button[normalize-space()='Login']";
    public static String linkForgotPassword = "//a[contains(@href,'https://crm.anhtester.com/admin/authentication/forgot_password')]";



    // Category
    public static String titleCategory = "//h1[normalize-space()='All categories']";
    public static String headerCategory = "//h5[normalize-space()='Category Information']";
    public static String inputName = "//input[@id='name']";
    public static String buttonParentCategory = "//button[@aria-owns='bs-select-1']";
    public static String inputParentCategory = "//button[@title='No Parent']/following-sibling::div/child::div[1]/input";
    public static String itemLaptopMSI = "//span[normalize-space()='Laptop MSI']";
    public static String inputOrderLevel = "//input[@id='order_level']";
    public static String buttonType = "//button[@aria-owns='bs-select-2']";
    public static String itemPhysical = "//span[normalize-space()='Physical']";
    public static String browseBanner = "(//div[contains(text(),'Browse')])[1]";
    public static String imageBannerLaptopMSI = "//div[@title='LaptopMSI.webp']//img[@class='img-fit']";
    public static String addFilesBanner = "//button[normalize-space()='Add Files']";
    public static String browseIcon = "(//div[contains(text(),'Browse')])[2]";
    public static String imageIconLaptop = "//div[@title='iconLaptop.png']//img[@class='img-fit']";
    public static String addFilesIcon = "(//button[normalize-space()='Add Files'])[1]";
    public static String inputMetaTitle = "//input[@placeholder='Meta Title']";
    public static String textareaMetaDescription = "//textarea[@name='meta_description']";
    public static String buttonFilteringAttributes = "//button[@aria-owns='bs-select-3']";
    public static String itemSize = "//span[normalize-space()='Size']";
    public static String buttonSave = "//button[normalize-space()='Save']";

    //trang list Category
    public static String searchCategory = "//input[@id='search']";
    public static String firstItem = "//div[@class='card-body']/descendant::tbody/tr[1]/td[2]";
    public static String editFirstItem = "//tbody/tr[1]/td[10]/a[1]";
    public static String deleteItem = "//i[@class='las la-trash']";
    public static String deleteConfirmation = "//a[@id='delete-link']";

    // Product
    public static String linkProduct = "//span[normalize-space()='Add New Product']";
    public static String headerProduct = "//h5[normalize-space()='Add New Product']";
    public static String inputProduct = "//input[@placeholder='Product Name']";
    //Dropdown Category
    public static String buttonCategory = "//button[@aria-owns='bs-select-1']";
    public static String inputCategory = "//button[@aria-owns='bs-select-1']/following-sibling::div/div/input";
    public static String itemLaptop = "(//a[@id='bs-select-1-276'])[1]";
    //Dropdown Brand
    public static String buttonBrand = "//button[@aria-owns='bs-select-2']";
    public static String inputBrand = "//button[@aria-owns='bs-select-2']/following-sibling::div/div/input";
    public static String itemMSI = "//a[@id='bs-select-2-244']";
    public static String inputUnit = "//input[@placeholder='Unit (e.g. KG, Pc etc)']";
    public static String inputWeight = "//input[@placeholder='0.00']";
    public static String inputMPQ = "//input[@name='min_qty']";
    public static String inputTags = "//tags[@role='tagslist']";
    public static String inputBarcode = "//input[@placeholder='Barcode']";
    //Product Image
    public static String browseGallery = "(//div[contains(text(),'Browse')])[1]";
    public static String imageGallery = "//div[@title='LaptopMSI.webp']//img[@class='img-fit']";
    public static String addFileGallery = "//button[normalize-space()='Add Files']";
    public static String browseThumnails = "(//div[contains(text(),'Browse')])[2]";
    public static String imageThumnails = "//div[@title='iconLaptop.png']//img[@class='img-fit']";
    public static String addFileThumnails = "(//button[normalize-space()='Add Files'])[1]";
    //Product Variation
    public static String adjustCursor = "//input[@name='colors_active']";
    public static String buttonColors = "//button[@aria-owns='bs-select-4']/child::div/div/div";
    public static String inputColors = "//input[contains(@aria-controls,'bs-select-4')]";
    public static String itemAquamarine = "//a[@id='bs-select-4-3']";
    public static String itemBlueViolet = "//a[@id='bs-select-4-10']";
    //Product price + stock
    public static String inputUnitPrice = "//input[@placeholder='Unit price']";
    public static String inputDiscountDateRange = "//input[@placeholder='Select Date']";
    public static String inputDiscount = "//input[@placeholder='Discount']";
    public static String buttonUnitDiscount = "//button[@aria-owns='bs-select-6']";
    public static String itemPercent = "(//span[@class='text'][normalize-space()='Percent'])[1]";
    public static String inputQuantity = "//input[@placeholder='Quantity']";
    //ProductDescription
    public static String textAreaDescription = "//div[@role='textbox']";
    //Seo Meta Data
    public static String inputMetaTitleProd = "//input[@placeholder='Meta Title']";
    public static String textAreaDescriptionProd = "//textarea[@name='meta_description']";
    public static String buttonSaveAndPublish = "//button[normalize-space()='Save & Publish']";

}
