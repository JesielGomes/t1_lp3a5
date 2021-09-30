/**
 * Utilizar uma variável do tipo volatile no código da Aula 2 para compartilhar dados entre as Threads.

A entrega deve ser um repositório do GitHub com o arquivo Java.
 */
/**
 * @author Jesiel Silva Gomes
 * Referência: https://docs.microsoft.com/pt-br/dotnet/csharp/language-reference/keywords/volatile
 *
 */
package Exercicio1;

public class Principal {

	 private  volatile int a = 0;
	 private volatile int b = 0;
	 private boolean pare = false;
	 
	 /**
	  * @param args
	  */
	 public static void main(String[] args) {
	 Principal principal = new Principal();
	 principal.executa();

	 }

	 public void executa() {
	 
	 new Thread(new Runnable() {

	 @Override
	 public void run() {
	 while(!pare) {
	 incremento();
	 }
	 }
	 }).start();
	 
	 new Thread(new Runnable() {
	 @Override
	 public void run() {
	 while(!pare) {
	 verifica();
	 }
	 }
	 }).start();
	 }
	 
	 public void verifica() {
	 if(b > a) {
	 System.out.println("ALGO DEU ERRADO! a = " + a + " b = " + b);
	 this.pare = true;
	 }
	 else {
	 System.out.println("TUDO NA SANTA PAZ! a = " + a + " b = " + b); 
	 }
	 }
	 
	 public void incremento() {
	 a++;
	 b++;
	 if(a == Integer.MAX_VALUE) {
	 a = 0;
	 b = 0;
	 } 
	 }

	}