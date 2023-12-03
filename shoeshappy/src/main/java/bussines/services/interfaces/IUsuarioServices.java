package bussines.services.interfaces;

import domain.models.Usuario;

public interface IUsuarioServices extends IServices<Usuario> {
	Usuario BuscarPorEmail(String _email);
	Usuario BuscarPorNomeUsuario(String _usuario);
}
