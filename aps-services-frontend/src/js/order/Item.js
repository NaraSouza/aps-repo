export default function Item({ item }) {
  return (
    <div className="mb-4">
      <div style={{ display: "flex", justifyContent: "space-between" }}>
        <div className="item-header">
          <span style={{ fontWeight: "bold" }}>{item.name}</span>

          <span style={{ color: "#6e6e6e" }}>{item.description}</span>
        </div>

        <span style={{ fontWeight: "bold" }}>R${item.price}</span>
      </div>

      <div className="dropdown-divider" />
    </div>
  );
}
