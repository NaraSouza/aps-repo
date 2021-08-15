import { Link, useParams } from "react-router-dom";

export default function CancelOrder() {
  const { orderData } = useParams();

  return (
    <div className="cancel-order-screen">
      <span className="title">Deseja realmente cancelar seu pedido?</span>

      <div className="buttons">
        <Link className="btn secondary" to={`/order/${orderData}`}>
          Não, voltar ao pedido
        </Link>

        {/* fazer request para cancelar pedido */}
        <button className="btn primary">Sim, cancelar o pedido</button>
      </div>
    </div>
  );
}
