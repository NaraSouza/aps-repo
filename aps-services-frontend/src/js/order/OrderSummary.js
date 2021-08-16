import { Link } from "react-router-dom";

export default function OrderSummary({ order }) {
  const completed = order.status === "concluido";

  return (
    <div className="order-summary-card">
      <div className="card-info">
        <div className="card-half">
          <div className="order-card-header">
            <span className="restaurant-name">{order.restaurante}</span>

            <span className="order-status">Pedido {order.status}</span>
          </div>

          <Link
            className="icon-go-to-order"
            to={`/order/${JSON.stringify(order)}`}
          >
            <i className="fa fa-chevron-right"></i>
          </Link>
        </div>
      </div>

      <div className="dropdown-divider" />

      <div className="card-half">
        <div className="order-items">
          {order.itens.map((item, index) => (
            <span key={index}>{item.name}</span>
          ))}
        </div>

        {completed ? (
          <Link
            className="btn secondary"
            to={`/rateOrder/${JSON.stringify(order)}`}
          >
            Avaliar pedido
          </Link>
        ) : (
          <Link
            className="btn primary"
            to={`/cancelOrder/${JSON.stringify(order)}`}
            style={{ width: "150px" }}
          >
            Cancelar pedido
          </Link>
        )}
      </div>
    </div>
  );
}
