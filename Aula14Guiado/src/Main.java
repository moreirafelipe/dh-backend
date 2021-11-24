import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Cachorro> cachorros = new ArrayList<>();

        Cachorro cachorro1 = new Cachorro();

        cachorro1.setNome("Rex");
        cachorro1.setIdade(3);

        Cachorro cachorro2 = new Cachorro();

        cachorro2.setNome("Lady");
        cachorro2.setIdade(1);

        cachorros.add(cachorro1);
        cachorros.add(cachorro2);

        FileOutputStream fo = null;

        try{
            fo = new FileOutputStream("OutputFile.txt");
            ObjectOutputStream object = new ObjectOutputStream(fo);
            object.writeObject(cachorros);

        } catch(FileNotFoundException e) {
            System.out.println("ERROR: Arquivo não encontrado!");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        List<Cachorro> cachorros2 = new ArrayList<>();
        FileInputStream fi = null;

        try{
            fi = new FileInputStream("Outputfile.txt");
            ObjectInputStream oi = new ObjectInputStream(fi);
            cachorros2 = (List<Cachorro>) oi.readObject();

        } catch(FileNotFoundException e) {
            System.out.println("ERROR: Arquivo não encontrado!");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        for(Cachorro cachorro : cachorros2) {
            System.out.println(cachorro.getNome() + ": " + cachorro.getIdade());
        }

//        cachorros2.forEach(cachorro -> {
//            System.out.println(cachorro.getNome() + ": " + cachorro.getIdade());
//        });
//
//        for(int i = 0; i < cachorros2.size(); i++) {
////            Cachorro cachorro = cachorros2.get(i);
//
//            cachorros2.get(i).setNome("");
//
//        }
    }
}
