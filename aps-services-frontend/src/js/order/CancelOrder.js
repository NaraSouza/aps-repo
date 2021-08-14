export default function CancelOrder() {
  return (
    <div className="cancel-order-screen">
      <span className="title">Deseja realmente cancelar seu pedido?</span>

      <div className="buttons">
        <button className="btn secondary">Não, voltar ao pedido</button>

        <button className="btn primary">Sim, cancelar o pedido</button>
      </div>
    </div>
  );
}
