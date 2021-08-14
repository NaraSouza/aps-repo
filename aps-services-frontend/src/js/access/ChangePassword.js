export default function ChangePassword() {
  return (
    <div className="change-password-screen">
      <span className="title">Preencha os dados abaixo</span>

      <input placeholder="E-mail" type="text" />

      <input placeholder="Nova senha" type="password" />

      <input placeholder="Confirmar nova senha" type="password" />

      <button className="btn primary">Alterar senha</button>
    </div>
  );
}
