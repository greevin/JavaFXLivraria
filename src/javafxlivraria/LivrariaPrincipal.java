package javafxlivraria;

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafxlivraria.model.Cliente;
import javafxlivraria.model.Endereco;
import javafxlivraria.model.Estoque;
import javafxlivraria.model.Filial;
import javafxlivraria.model.Gerente;
import javafxlivraria.model.ItemCarrinho;
import javafxlivraria.model.Jornal;
import javafxlivraria.model.Livro;
import javafxlivraria.model.Revista;
import javafxlivraria.view.ClienteListWrapper;
import javafxlivraria.view.EscolheProdutosController;
import javafxlivraria.view.EstoqueListWrapper;
import javafxlivraria.view.FinalizaCompraController;
import javafxlivraria.view.RootLayoutController;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.controlsfx.dialog.Dialogs;

/**
 *
 * @author casn
 */
public class LivrariaPrincipal extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    private final ObservableList<Filial> filialComboBoxData = FXCollections.observableArrayList();
    private final ObservableList<Cliente> clienteComboBoxData = FXCollections.observableArrayList();
    private final ObservableList<String> formaPagamentoComboBoxData = FXCollections.observableArrayList();
    private final ObservableList<String> parcelasCartaoDeCreditoComboBoxData = FXCollections.observableArrayList();

    /**
     *
     */
    public LivrariaPrincipal() {

        Estoque[] estoques = new Estoque[2];
        estoques[0] = new Estoque();
        estoques[1] = new Estoque();

        Livro[] livros = new Livro[5];
        livros[0] = new Livro("Livro das Abelhas", "Editora Europa", 1, "Portugues", "05/05/2014", 230, 111111, 50.0, "Capa Dura");
        livros[1] = new Livro("O Senhor dos Anéis - Volume Único", "Editora Atlas", 10, "Portugues", "09/04/2013", 690, 222222, 150.0, "Capa Comum");
        livros[2] = new Livro("Razão e Sensibilidade", "Editora Vilarinho", 3, "Inglês", "25/10/2003", 390, 333333, 50.0, "Capa Comum");
        livros[3] = new Livro("Java - Como Programar", "Deitel e Deitel Editora", 9, "Portugues", "11/07/2013", 1040, 4546546, 125.0, "Capa Comum");
        livros[4] = new Livro("C++ Completo e Total", "Editora Saraiva", 10, "Portugues", "15/04/2010", 560, 99999999, 100.0, "Capa Dura");

        Revista[] revistas = new Revista[2];
        revistas[0] = new Revista("Claudia", "Abril", 4343, "Português", "Abril 2014", 3434, 24242, 15.0);
        revistas[1] = new Revista("Info", "Abril", 2554, "Português", "Julho 2014", 232, 656, 15.0);

        Jornal[] jornais = new Jornal[2];
        jornais[0] = new Jornal("O Estado de Minas", "O Estado de Minas", 545454, "Português", "05/10/2013", 50, 22222222, 2.0);
        jornais[1] = new Jornal("O Estado de São Paulo", "O Estado de São Paulo", 556784, "Português", "10/05/2014", 10, 565646, 3.0);

        estoques[0].cadastraItem(livros[0], 5);
        estoques[0].cadastraItem(livros[1], 5);
        estoques[0].cadastraItem(livros[2], 5);
        estoques[1].cadastraItem(livros[3], 5);
        estoques[1].cadastraItem(livros[4], 5);

        estoques[0].cadastraItem(revistas[0], 5);
        estoques[1].cadastraItem(revistas[1], 5);

        estoques[0].cadastraItem(jornais[0], 5);
        estoques[1].cadastraItem(jornais[1], 5);

        Endereco[] enderecosClientes = new Endereco[4];

        enderecosClientes[0] = new Endereco("Avenida", "dos Aeronautas", "444", "Nenhum", "Belo Horizonte", "MG");
        enderecosClientes[1] = new Endereco("Rua", "da Bahia", "550C", "Fundos", "Belo Horizonte", "MG");
        enderecosClientes[2] = new Endereco("Rua", "dos Abacateiros", "3000", "Sem complemento", "São Paulo", "SP");
        enderecosClientes[3] = new Endereco("Avenida", "dos Jacarandás", "3242", "Casa", "Bento Gonçalves", "RS");

        Cliente[] clientes = new Cliente[2];
        clientes[0] = new Cliente("José do Nascimento", "12/12/1986", "13/05/2013", enderecosClientes[1], enderecosClientes[2]);
        clientes[1] = new Cliente("Maria Eduarda", "13/06/2014", "19/05/1996", enderecosClientes[3], enderecosClientes[3]);

        Endereco[] enderecosFilial = new Endereco[2];

        enderecosFilial[0] = new Endereco("Rua", "dos Jornalistas", "2050", "Nenhum", "Belo Horizonte", "MG");
        enderecosFilial[1] = new Endereco("Avenida", "João Braga Costa Nunes", "1000", "Loja 3", "Poços de Caldas", "MG");

        Gerente[] gerentes = new Gerente[2];
        gerentes[0] = new Gerente("Carlos Eduardo", "13/01/1986", "06/05/2003", 450, enderecosFilial[0]);
        gerentes[1] = new Gerente("João Ricardo", "20/05/1976", "06/05/1195", 550, enderecosFilial[1]);

        Filial[] filiais = new Filial[2];

        filiais[0] = new Filial("Livraria dos Jornalistas", enderecosFilial[0], gerentes[0], estoques[0]);
        filiais[1] = new Filial("Livraria dos João Braga", enderecosFilial[1], gerentes[1], estoques[1]);

        filialComboBoxData.addAll(filiais);

        clienteComboBoxData.addAll(clientes);

        formaPagamentoComboBoxData.add( "Dinheiro");
        formaPagamentoComboBoxData.add("Cartão de Crédito");
        formaPagamentoComboBoxData.add("Cartão de Débito");
        
        parcelasCartaoDeCreditoComboBoxData.setAll("1","2","3");
    }

    public ObservableList<Filial> getComboBoxData() {
        return filialComboBoxData;
    }
//    
//    public ObservableList<StringProperty> getFormaPagamentoComboBoxData() {
//        return formaPagamentoComboBoxData;
//    }
//    
//    public ObservableList<Cliente> getClienteComboBoxData() {
//        return clienteComboBoxData;
//    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Livraria");

        mostrarRootLayout();

        mostrarLivraria();
    }

    /**
     * Inicializa o layout principal
     */
    public void mostrarRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(LivrariaPrincipal.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            // Give the controller access to the main app.
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarLivraria() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(LivrariaPrincipal.class.getResource("view/EscolheProdutos.fxml"));
            AnchorPane livraria = (AnchorPane) loader.load();

            // Coloca este layout no centro do layout principal
            rootLayout.setCenter(livraria);

            // Give the controller access to the main app and set data inside controller.
            EscolheProdutosController controller = loader.getController();
            controller.setMainApp(this);
            controller.setFiliais(filialComboBoxData);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarFinarlizaCompra(ObservableList<ItemCarrinho> carrinho) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(LivrariaPrincipal.class.getResource("view/FinalizaCompra.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Finalizar compra");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set data into the controller.
            FinalizaCompraController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMainApp(this);
            controller.setCarrinhoDeCompras(carrinho);
            controller.setCliente(clienteComboBoxData);
            controller.setFormasDePagamento(formaPagamentoComboBoxData);
            controller.setParcelasCredito(parcelasCartaoDeCreditoComboBoxData);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the person file preference, i.e. the file that was last opened.
     * The preference is read from the OS specific registry. If no such
     * preference can be found, null is returned.
     *
     * @return
     */
    public File getPersonFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(LivrariaPrincipal.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }

    /**
     * Sets the file path of the currently loaded file. The path is persisted in
     * the OS specific registry.
     *
     * @param file the file or null to remove the path
     */
    public void setPersonFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(LivrariaPrincipal.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());

            // Update the stage title.
            primaryStage.setTitle("Livraria - " + file.getName());
        } else {
            prefs.remove("filePath");

            // Update the stage title.
            primaryStage.setTitle("Livraria");
        }
    }

    public void loadClienteDataFromFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(ClienteListWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            // Reading XML from the file and unmarshalling.
            ClienteListWrapper wrapper = (ClienteListWrapper) um.unmarshal(file);

            clienteComboBoxData.clear();
            clienteComboBoxData.addAll(wrapper.getClientes());

            // Save the file path to the registry.
            setPersonFilePath(file);

        } catch (Exception e) { // catches ANY exception
            Dialogs.create()
                    .title("Error")
                    .masthead("Could not load data from file:\n" + file.getPath())
                    .showException(e);
        }
    }

    public void savePersonDataToFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(ClienteListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Wrapping our person data.
            ClienteListWrapper wrapper = new ClienteListWrapper();
            wrapper.setClientes(clienteComboBoxData);

            // Marshalling and saving XML to the file.
            m.marshal(wrapper, file);

            // Save the file path to the registry.
            setPersonFilePath(file);
        } catch (Exception e) { // catches ANY exception
            Dialogs.create().title("Error")
                    .masthead("Could not save data to file:\n" + file.getPath())
                    .showException(e);
        }
    }
    
         /* Sets the file path of the currently loaded file. The path is persisted in
     * the OS specific registry.
     *
     * @param file the file or null to remove the path
     */
    public void setEstoqueFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(LivrariaPrincipal.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());

            // Update the stage title.
            primaryStage.setTitle("Livraria - " + file.getName());
        } else {
            prefs.remove("filePath");

            // Update the stage title.
            primaryStage.setTitle("Livraria");
        }
    }

    public void loadEstoqueDataFromFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(EstoqueListWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            // Reading XML from the file and unmarshalling.
            EstoqueListWrapper wrapper = (EstoqueListWrapper) um.unmarshal(file);

            filialComboBoxData.clear();
            filialComboBoxData.addAll(wrapper.getFilial());

            // Save the file path to the registry.
            setPersonFilePath(file);

        } catch (Exception e) { // catches ANY exception
            Dialogs.create()
                    .title("Error")
                    .masthead("Could not load data from file:\n" + file.getPath())
                    .showException(e);
        }
    }

    public void saveEstoqueDataToFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(EstoqueListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Wrapping our person data.
            EstoqueListWrapper wrapper = new EstoqueListWrapper();
            wrapper.setEstoque(filialComboBoxData);

            // Marshalling and saving XML to the file.
            m.marshal(wrapper, file);

            // Save the file path to the registry.
            setPersonFilePath(file);
        } catch (Exception e) { // catches ANY exception
            Dialogs.create().title("Error")
                    .masthead("Could not save data to file:\n" + file.getPath())
                    .showException(e);
        }
    }

    /**
     * Returns the main stage.
     *
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
