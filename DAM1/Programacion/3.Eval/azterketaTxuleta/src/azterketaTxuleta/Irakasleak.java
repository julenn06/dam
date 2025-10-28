package azterketaTxuleta;

public class Irakasleak extends Personas {
	private double salario;
	private String horario;

	public Irakasleak(String nombre, String apellido, int edad, int aula, double salario, String horario)
			throws AdinaBalidatu {
		super(nombre, apellido, edad, aula);
		this.salario = salario;
		this.horario = horario;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	@Override
	public String getHorario() {
		return horario;
	}
}