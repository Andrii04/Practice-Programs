import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Ex3 {

    public static <T> Collection<T> getSenzaAdiacenti(T[] array) {

        //definisco una variabile che contiene l'array in input come una Lista
        List<T> arrayAsList = Arrays.asList(array);
        //Incomincio la ricorsione partendo dal primo elemento che viene confrontato col secondo elemento
        rimuoviAdiacenti(arrayAsList, arrayAsList.get(0), 1);

        //ritorno la lista risultante escludendo i null, che sono gli elementi adiacenti rimossi
        return arrayAsList.stream()
                .filter(elem -> elem != null)
                .collect(Collectors.toList());
    }

    public static <T> void rimuoviAdiacenti(List<T> arrayAsList, T elem, int index) {

        //caso base, quando arrivo alla fine della lista, ritorno
        if (index >= arrayAsList.size()) return;

        //se l'elemento precedente è uguale all'elemento corrente, setto l'elemento corrente a null
        //e eseguo una chiamata ricorsiva sullo stesso elemento, ma andando avanti di 1 index
        if (elem.equals(arrayAsList.get(index))) {
            arrayAsList.set(index, null);
            rimuoviAdiacenti(arrayAsList, elem, index+1);
        }
        //se invece l'elemento precedente è diverso dal corrente, allora eseguo
        //una chiamata ricorsiva che prende come elemento da confrontare, l'elemento dell'index
        //corrente, e vado avanti di 1 index.
        else rimuoviAdiacenti(arrayAsList, arrayAsList.get(index), index+1);
    }
}

/*
La ricorsione è un meccanismo/tecnica di Programmazione che prevede che una funzione richiami se stessa all'interno
del suo stesso codice.
La ricorsione, quando implementata correttamente, è dotata di un Caso Base e un Passo Ricorsivo;
il Caso Base fa ritornare la funzione, fermando così le chiamate ricorsive, serve a evitare di entrare in un
loop infinito e ad evitare uno StackOverflow Error;
un esempio di Caso Base può essere il primo if del metodo rimuoviAdiacenti() di questo file.
Mentre il Passo Ricorsivo è la parte di codice in cui la funzione richiama se stessa, ma con
parametri diversi per far si che ci si avvicini al Caso Base.

Un Esempio famoso di Ricorsione è il fattoriale: n! = n * fattoriale(n-1)
in cui fattoriale(n-1) è il Passo Ricorsivo, e avvicina le chiamate al Caso Base ovvero quando n=1.

La Ricorsione può risultare più efficiente per problemi che sono naturalmente strutturati ricorsivamente
e rende di solito il codice più minimalista e leggibile.
Tuttavia ci sono problemi per la quale la Ricorsione non è adatta e quindi un approccio ricorsivo potrebbe
risultare molto poco efficiente, rendendo l'Iterazione l'opzione più adeguata.

La Mutua Ricorsione è un tipo di Ricorsione che prevede che 2 o più funzioni si chiamino a vicenda ciclicamente,
ogni funzione avendo il proprio caso Base.
Un esempio può essere una funzione che calcola se un numero è pari o dispari:
la funzione pari controlla se il numero è pari chiamando la funzione dispari (che dovrebbe ritornare false)
e viceversa.
La Mutua Ricorsione è utile quando si deve risolvere un problema che è composto da vari sottoproblemi
risolvibili a parte.
Tuttavia, i suoi svantaggi possono essere: la difficoltà nel debug, la difficoltà  nel seguire la logica,
e, come la Ricorsione normale, l'efficienza bassa se le funzioni non vengono ottimizzate correttamente.

Le Applicazioni della Ricorsione sono ad esempio gli Algoritmi di Ordinamento e di Ricerca, come ad Esempio
la Binary Search o il MergeSort, la risoluzione di problemi riguardanti gli Alberi, e il suo collegamento
all'Induzione Matematica.

Per quanto riguarda la differenza fra Ricorsione e Iterazione, è più conveniente utilizzare la Ricorsione per
risolvere come già detto, problemi strutturati ricorsivamente come Alberi o Permutazioni, mentre è più conveniente
utilizzare l'Iterazione per problemi lineari come la somma degli elementi di un array, tra l'altro, con l'Iterazione
non c'è il Rischio di andare in StackOverflow, quindi è un'opzione generalmente più sicura rispetto alla Ricorsione,
tuttavia richiede di solito più codice per essere Implementata.
*/
