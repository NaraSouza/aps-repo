import axios from "axios";
import { Link, useParams } from "react-router-dom";

export default function CancelOrder() {
  const { orderData } = useParams();

  const order = JSON.parse(orderData);

  return (
    <div className="cancel-order-screen">
      <span className="title">Deseja realmente cancelar seu pedido?</span>

      <div className="buttons">
        <Link className="btn secondary" to={`/order/${orderData}`}>
          Não, voltar ao pedido
        </Link>

        <button
          className="btn primary"
          onClick={() => {
            axios
              .put("http://localhost:3001/cancel/", { _id: order._id })
              .then(() => alert("Pedido cancelado com sucesso"))
              .catch(() => alert("Erro ao cancelar pedido"));
          }}
        >
          Sim, cancelar o pedido
        </button>
      </div>
    </div>
  );
}
