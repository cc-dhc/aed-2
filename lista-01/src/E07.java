import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Storage s = new Storage("storage.txt");

        int op = -1;

        while(op != 0) {
            System.out.println("\n[1]: Adicionar um número a lista.");
            System.out.println("[2]: Mostrar a soma dos números da lista.");
            System.out.println("[0]: Salvar e saír.\n");
            System.out.print("Digite uma opção: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.print("Digite um número: ");
                    int e = sc.nextInt();
                    s.add(e);
                    System.out.println("Número adicionado com sucesso.");
                    break;
                case 2:
                    System.out.println("Soma dos números da lista: " + s.sum());
                    break;
                case 0:
                    System.out.println("Salvando a lista em um arquivo...");
                    s.close();
                    System.out.println("Lista salva com sucesso.");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        sc.close();
    }
}

class Storage {
    private List<Integer> arr;
    private String path;

    Storage(String p) {
        path = p;
        arr = new ArrayList<>();

        File f = new File(path);
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader fr = new FileReader(p)) {
            BufferedReader br = new BufferedReader(fr);

            while(br.ready()) {
                int n = Integer.parseInt(br.readLine());
                arr.add(n);
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try (FileWriter fw = new FileWriter(path)) {
            BufferedWriter bw = new BufferedWriter(fw);

            for (Integer e : arr) {
                bw.write(String.format("%d\n", e));
            }

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int sum() {
        int s = 0;

        for (Integer e : arr) {
            s += e;
        }

        return s;
    }

    public void add(int e) {
        arr.add(e);
    }
}