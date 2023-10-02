package br.com.fiap.mspedidos.dto;

import br.com.fiap.mspedidos.model.ItemDoPedido;
import br.com.fiap.mspedidos.model.Pedido;
import br.com.fiap.mspedidos.model.Status;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PedidoDTO {

    private Long id;

    //@NotNull
    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    private Status status;

    private List<ItemDoPedidoDTO> itens = new ArrayList<>();

    public PedidoDTO(Long id, LocalDateTime dataHora, Status status) {
        this.id = id;
        this.dataHora = dataHora;
        this.status = status;
    }

    public PedidoDTO(Pedido entity) {
        id = entity.getId();
        dataHora = entity.getDataHora();
        status = entity.getStatus();

        for (ItemDoPedido item : entity.getItens()) {
            itens.add(new ItemDoPedidoDTO(item));
        }
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Status getStatus() {
        return status;
    }

    public List<ItemDoPedidoDTO> getItens() {
        return itens;
    }


}
