export default function SignUp() {
  return (
    <div className="signup-screen">
      <span className="title">Cadastrar</span>

      <input placeholder="Nome" type="text" />

      <input placeholder="E-mail" type="text" />

      <input placeholder="Senha" type="password" />

      <span className="subtitle mt-2">Endereço</span>

      <input placeholder="Rua" type="text" />

      <div className="input-groups">
        <input placeholder="Número" type="text" style={{ width: "45%" }} />

        <input placeholder="Bairro" type="text" style={{ width: "50%" }} />
      </div>

      <input placeholder="Complemento" type="text" />

      <input placeholder="Cidade" type="text" />

      <div className="input-groups">
        <input placeholder="Estado" type="text" style={{ width: "55%" }} />

        <input placeholder="CEP" type="text" style={{ width: "40%" }} />
      </div>

      <button className="btn primary">Cadastrar</button>
    </div>
  );
}
