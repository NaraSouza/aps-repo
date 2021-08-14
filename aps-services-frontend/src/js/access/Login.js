export default function Login() {
  return (
    <div className="login-screen">
      <span className="title">Login</span>

      <input placeholder="E-mail" type="text" />

      <input placeholder="Senha" type="password" />

      <a href="https://reactjs.org" target="_blank" rel="noopener noreferrer">
        Alterar senha
      </a>

      <div className="buttons">
        <button className="btn secondary">Cadastrar</button>

        <button className="btn primary">Login</button>
      </div>
    </div>
  );
}
