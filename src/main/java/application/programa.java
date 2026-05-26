package application;
import dominio.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class programa {
    public static void main(String[] args) {
        // aqui eu instancio as "pessoas" que vão para o banco de dados.
        Pessoa p1 = new Pessoa(null,"Carlos da Silva","carlosdaslva@gmail.com");
        Pessoa p2 = new Pessoa(null,"Maria da Silva","mariadaslva@gmail.com");
        Pessoa p3 = new Pessoa(null,"Matheus da Silva","Matheusdaslva@gmail.com");

        // aqui eu instancio EntityManagerFactory a nossa "fabrica" que faz todo trabalho sujo de carregar do persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula-jpa");
        // aqui eu instancio o EntityManager ele faz todo trabalho de isert, delete enfim.........

        EntityManager em = emf.createEntityManager();
        // aqui eu instancio uma transação pois vai ser uma "inserção"
        em.getTransaction().begin();

        // aqui eu salvo as "pessoas" da minha classe no banco.
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);

        // e aqui eu comito, aprovo isso
        em.getTransaction().commit();

        // aqui eu faço uma busca com o find, passando o valor, o objeto e a chave
        Pessoa p = em.find(Pessoa.class,5);
        System.out.println(p);

        System.out.println("Done!");

    }
}
