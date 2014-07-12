package casn.livrariafx.view;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import casn.livrariafx.LivrariaPrincipal;
import casn.livrariafx.model.Cliente;
import casn.livrariafx.model.ItemCarrinho;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;

/**
 *
 * @author CASN
 */
public class FinalizaCompraController {

    private Stage dialogStage;
    private LivrariaPrincipal mainApp;

    @FXML
    private TableView<ItemCarrinho> tabelaCarrinho;
    @FXML
    private TableColumn<ItemCarrinho, String> tituloColunaCarrinho;
    @FXML
    private TableColumn<ItemCarrinho, String> precoColunaCarrinho;
    @FXML
    private TableColumn<ItemCarrinho, String> unidadesColunaCarrinho;
    @FXML
    private TableColumn<ItemCarrinho, String> totalColunaCarrinho;

    @FXML
    private ComboBox<Cliente> clienteComboBox;
    @FXML
    private Label enderecoFaturamentoLabel;
    @FXML
    private Label enderecoEntregaLabel;

    @FXML
    private ComboBox<String> formasPagamentoComboBox;
    @FXML
    private Label precoTotalLabel;
    @FXML
    private ComboBox<String> parcelasCreditoComboBox;

    /**
     * Inicializa a classe controller. Este método é chamado automaticamente
     * após o arquivo FXML foi carregado.
     */
    @FXML
    private void initialize() {

        preencheDetalhesCliente(null);

        clienteComboBox.setCellFactory((comboBox) -> {
            return new ListCell<Cliente>() {
                @Override
                protected void updateItem(Cliente cliente, boolean empty) {
                    super.updateItem(cliente, empty);

                    if (cliente == null || empty) {
                        setText(null);
                    } else {
                        setText(cliente.getNome());
                    }
                }
            };
        });

        clienteComboBox.setConverter(new StringConverter<Cliente>() {
            @Override
            public String toString(Cliente cliente) {
                if (cliente == null) {
                    return null;
                } else {
                    return cliente.getNome();
                }
            }

            @Override
            public Cliente fromString(String clienteString) {
                return null;
            }
        });

        formasPagamentoComboBox.setOnAction((event) -> {
            String selectedPagamento = formasPagamentoComboBox.getSelectionModel().getSelectedItem();
            ObservableList<String> itens;
            itens = FXCollections.observableArrayList();
            if ("Dinheiro".equalsIgnoreCase(selectedPagamento)
                    || "Cartão de Débito".equalsIgnoreCase(selectedPagamento)) {
                itens.addAll("1");
            } else if ("Cartão de Crédito".equalsIgnoreCase(selectedPagamento)) {
                itens.addAll("1", "2", "3", "4", "5");
            }
            parcelasCreditoComboBox.setItems(itens);
            parcelasCreditoComboBox.getSelectionModel().select(0);
        });

        tituloColunaCarrinho.setCellValueFactory(
                cellData -> cellData.getValue().tituloProperty());
        precoColunaCarrinho.setCellValueFactory(
                cellData -> cellData.getValue().precoProperty().asString());
        unidadesColunaCarrinho.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getUnidades().toString()));
        totalColunaCarrinho.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getTotal().toString()));

        clienteComboBox.setOnAction((event) -> {
            Cliente selectedCliente = clienteComboBox.getSelectionModel().getSelectedItem();
            preencheDetalhesCliente(selectedCliente);
        });
    }

    private void preencheDetalhesCliente(Cliente cliente) {
        if (cliente != null) {
            // Fill the labels with info from the person object.
            enderecoFaturamentoLabel.setText(cliente.getEnderecoDeFaturamento().toString());
            enderecoEntregaLabel.setText(cliente.getEnderecoDeEntrega().toString());
        } else {
            // Person is null, remove all the text.
            enderecoFaturamentoLabel.setText("");
            enderecoEntregaLabel.setText("");
        }
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Chamado quando o usuário clica no botão "Cancelar Compra"
     */
    @FXML
    private void handleCancelarCompra() {
        Action response = Dialogs.create()
                .title("Cancelar Comprar")
                .message("Deseja cancelar essa compra?")
                .showConfirm();

        if (response == Dialog.Actions.YES) {
            dialogStage.close();
        } else {
            dialogStage.show();
        }

    }

    @FXML
    private void handleConcluirCompra() {
        mainApp.atualizaEstoque();

        Dialogs.create()
                .title("Compra Finalizada")
                .message("Compra Finalizada")
                .showInformation();
        dialogStage.close();
    }

    public void setMainApp(LivrariaPrincipal mainApp) {
        this.mainApp = mainApp;
    }

    public void setCarrinhoDeCompras(ObservableList<ItemCarrinho> itensCarrinho) {
        this.tabelaCarrinho.setItems(itensCarrinho);
        Double precoTotal = 0.0;
        for (ItemCarrinho carrinho : tabelaCarrinho.getItems()) {
            precoTotal += carrinho.getPreco() * carrinho.getUnidades();
        }
        NumberFormat df = DecimalFormat.getCurrencyInstance();
        precoTotalLabel.setText(NumberFormat.getCurrencyInstance().format(precoTotal));
    }

    public void setFormasDePagamento(ObservableList<String> formasDePagamento) {
        formasPagamentoComboBox.setItems(formasDePagamento);
    }

    public void setCliente(ObservableList<Cliente> clientes) {
        clienteComboBox.setItems(clientes);
    }

    public void setParcelasCredito(ObservableList<String> parcelasCredito) {
        parcelasCreditoComboBox.setItems(parcelasCredito);
    }
}
