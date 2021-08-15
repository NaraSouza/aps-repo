import { Link } from "react-router-dom";

export default function CancelOrder() {
  return (
    <div className="cancel-order-screen">
      <span className="title">Deseja realmente cancelar seu pedido?</span>

      <div className="buttons">
        {/* passar parametro com order */}
        <Link className="btn secondary" to="/order">
          Não, voltar ao pedido
        </Link>

        {/* fazer request para cancelar pedido */}
        <button className="btn primary">Sim, cancelar o pedido</button>
      </div>
    </div>
  );
}
