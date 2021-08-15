import { Link } from "react-router-dom";

export default function OrderSummary({ order }) {
  const completed = order.status === "concluido";

  return (
    <div className="order-summary-card">
      <div className="card-info">
        <div className="card-half">
          <div className="order-card-header">
            <span className="restaurant-name">{order.restaurant}</span>

            <span className="order-status">Pedido {order.status}</span>
          </div>

          {/* passar parametro com pedido */}
          <Link className="icon-go-to-order" to="/order">
            <i className="fa fa-chevron-right"></i>
          </Link>
        </div>
      </div>

      <div className="dropdown-divider" />

      <div className="card-half">
        <div className="order-items">
          {order.items.map((item, index) => (
            <span key={index}>{item.name}</span>
          ))}
        </div>

        {completed ? (
          // passar parametro com pedido
          <Link className="btn secondary" to="/rateOrder">
            Avaliar pedido
          </Link>
        ) : (
          // passar parametro com pedido
          <Link
            className="btn primary"
            to="/cancelOrder"
            style={{ width: "150px" }}
          >
            Cancelar pedido
          </Link>
        )}
      </div>
    </div>
  );
}
