package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItbiPage {

    public WebDriver driverItbi = null;
    public WebDriver driverDB = null;
    WebDriverWait wait;

    ItbiPage(){
    }

    public ItbiPage(WebDriver driverItbi1, WebDriver driverDB){
        this.driverItbi = driverItbi1;
        this.driverDB = driverDB;
        wait = new WebDriverWait(driverItbi, 10);
    }

    public void open() {
        driverDB.get("http://localhost:8080?contribuinte=128.162.0050.6");
        driverItbi.get("https://itbi.prefeitura.sp.gov.br/valorreferencia/tvm/frm_tvm_consulta_valor.aspx");
    }

    public boolean isLoaded() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txt_setor"))).isDisplayed();
    }
    public void login(String userSetor, String userQuadra, String userLote, String userDigito, String userData) throws InterruptedException {
        String contribuinte = driverDB.findElement(By.id("contribuinte")).getText();

        String setor = contribuinte.substring(0,3);
        String quadra = contribuinte.substring(4,7);
        String lote = contribuinte.substring(8, 12);
        String digito = contribuinte.substring(13, 14);

        driverItbi.findElement(By.id("txt_setor")).sendKeys(setor);
        driverItbi.findElement(By.id("txt_quadra")).sendKeys(userQuadra);
        driverItbi.findElement(By.id("txt_lote")).sendKeys(userLote);
        driverItbi.findElement(By.id("txt_digito")).sendKeys(userDigito);
        driverItbi.findElement(By.id("txtData")).sendKeys(userData);

        driverItbi.findElement(By.id("btnPesquisar")).click();

        String textSql = driverItbi.findElement(By.id("codigoSql")).getText();
        String textValor = driverItbi.findElement(By.id("valorSql")).getText();
        String textEndereco = driverItbi.findElement(By.id("nomeEndereco")).getText();

        System.out.println("SQL = " + textSql);
        System.out.println("Valor = " + textValor);
        System.out.println("Endereco = " + textEndereco);

    }

}
