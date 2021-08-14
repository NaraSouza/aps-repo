export default function RateOrder() {
  return (
    <div className="rate-order-screen">
      <span className="title">Dê uma nota:</span>

      <input placeholder="Escreva sua nota de 0 à 5" type="text" />

      <textarea className="mb-4" placeholder="Deixe um comentário" />

      <div className="buttons">
        <button className="btn secondary">Cancelar</button>

        <button className="btn primary">Avaliar pedido</button>
      </div>
    </div>
  );
}
