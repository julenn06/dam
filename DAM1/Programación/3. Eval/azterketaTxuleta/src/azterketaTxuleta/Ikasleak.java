package azterketaTxuleta;

public class Ikasleak extends Personas {
	private String curso;
	private String horario;

	public Ikasleak(String nombre, String apellido, int edad, int aula, String curso, String horario)
			throws AdinaBalidatu {
		super(nombre, apellido, edad, aula);
		this.curso = curso;
		this.horario = horario;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	@Override
	public String getHorario() {
		return horario;
	}
}
