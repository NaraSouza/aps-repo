export default function PaymentMethods({
  paymentMethods = [
    { name: "Visa - Débito" },
    { name: "Mastercard - Débito" },
    { name: "Elo - Débito" },
    { name: "Visa - Crédito" },
    { name: "Mastercard - Crédito" },
    { name: "Elo - Crédito" },
  ],
}) {
  const debitCards = paymentMethods.filter((paymentMethod) =>
    paymentMethod.name.includes("Débito")
  );

  const creditCards = paymentMethods.filter((paymentMethod) =>
    paymentMethod.name.includes("Crédito")
  );

  return (
    <div className="payment-methods-screen">
      <span className="title">Escolha a forma de pagamento</span>

      <div>
        {debitCards.map((paymentMethod) => (
          <span className="payment-method-card">{paymentMethod.name}</span>
        ))}
      </div>

      <div>
        {creditCards.map((paymentMethod) => (
          <span className="payment-method-card">{paymentMethod.name}</span>
        ))}
      </div>

      {/* fazer request para salvar pedido */}
      <div style={{ width: "100%", display: "flex", justifyContent: "center" }}>
        <button className="btn primary">Realizar pagamento</button>
      </div>
    </div>
  );
}
