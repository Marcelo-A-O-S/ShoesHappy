package bussines.services;

import java.util.List;


import bussines.repositories.UsuarioRepository;
import bussines.services.interfaces.IUsuarioServices;
import domain.models.Usuario;

public class UsuarioServices implements IUsuarioServices{
	private UsuarioRepository repositorio;
	public UsuarioServices(UsuarioRepository _repositorio) {
		this.repositorio = _repositorio;
	}
	@Override
	public void Salvar(Usuario entidade) {
		// TODO Auto-generated method stub
		if(entidade != null) {
			if(entidade.Id == 0) {
				this.repositorio.Salvar(entidade);
			}else {
				System.out.print("");
			}
		}else {
			System.out.print("");
		}
		
	}

	@Override
	public Usuario BuscarPorId(int id) {
		// TODO Auto-generated method stub
		Usuario usuario = this.repositorio.BuscarPorId(id);
		return usuario;
	}
	@Override
	public List<Usuario> Listar() {
		// TODO Auto-generated method stub
		List<Usuario> usuarios = this.repositorio.Listar();
		return usuarios;
	}
	@Override
	public Usuario BuscarPorEmail(String _email) {
		// TODO Auto-generated method stub
		Usuario usuario = this.repositorio.BuscarPorPropriedadeValor("email", _email);
		return usuario;
	}
	@Override
	public Usuario BuscarPorNomeUsuario(String _usuario) {
		// TODO Auto-generated method stub
		Usuario usuario = this.repositorio.BuscarPorPropriedadeValor("usuario", _usuario);
		return usuario;
	}
	@Override
	public void Deletar(Usuario entidade) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void DeletarPorId(int id) {
		this.repositorio.DeletarPorId(id);
		
	}

}
