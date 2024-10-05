package testpackage;

import org.testng.annotations.Test;
import basepackage.basecls;
import pagepackage.saucedemopage;
import utilitiespackage.Excelutils; // corrected package name

public class saucedemotest extends basecls {
    @Test
    public void test() throws Exception {
        saucedemopage sg = new saucedemopage(driver);
        String exl = "https://d.docs.live.net/4432f20a074cf40f/Documents/mavenprjct.xlsx";
        String Sheet1 = "Sheet1";
        int rowCount = Excelutils.getRowCount1(exl, Sheet1);
        for (int i = 1; i <= rowCount; i++) {
            String Username = Excelutils.getcellvalue1(exl, Sheet1, i, 0);
            System.out.println("Username-------" + Username);

            String Password = Excelutils.getcellvalue1(exl, Sheet1, i, 1);
            System.out.println("Password-------" + Password);

            sg.setValues(Username, Password);
            sg.clickLoginButton();
            driver.navigate().refresh();
            Thread.sleep(1000);
        }

        sg.setValues1("standard_user", "secret_sauce");
        sg.clickLoginButton1();
        Thread.sleep(3000);

        sg.addingToCart();
        sg.clickCart();
        sg.clickCheckout();
        sg.setValues2("Devika", "Pramod", "889495");
        sg.clickContinue();
        sg.clickCancel();
        sg.clickHamburger();
        sg.clickLogout();
    }
}

		
	

