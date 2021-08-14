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

          <button className="icon-go-to-order">
            <i className="fa fa-chevron-right"></i>
          </button>
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
          <button className="btn secondary">Avaliar pedido</button>
        ) : (
          <button className="btn primary" style={{ width: "150px" }}>
            Cancelar pedido
          </button>
        )}
      </div>
    </div>
  );
}
