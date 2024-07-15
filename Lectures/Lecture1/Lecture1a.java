package Lectures.Lecture1;

// %esp (Stack Pointer): Ukazuje na nejnižší adresu aktuálního rámce, což je adresa prvku na vrcholu zásobníku.
// %ebp (Base Pointer): Uchovává adresu začátku aktuálního rámce, což usnadňuje přístup k lokálním proměnným a parametrům metody.
public class Lecture1a {
    public static void foo() { // 4. Vytvořen nový rámec 'foo' na vrcholu zásobníku.
        int x = 10; // 5. Lokální proměnné jsou uloženy do rámce.
        int y = 20; // 5. %ebp se používá pro přístup k lokálním proměnným.
        int z = x + y;
        System.out.println(z); // 6. Metoda 'foo' dokončí svou práci a rámec je odstraněn ze zásobníku.
    } // 7. %esp je aktualizován a ukazuje zpět na rámec 'main'.

    // Main method
    public static void main(String[] args) { // 1. Vytvořen nový rámec 'main' na vrcholu zásobníku.
        foo(); // 2. Metoda 'main' volá metodu 'foo'.
    } // 8. Rámec 'main' je odstraněn ze zásobníku, když program končí.
}
