package appareils.IntegrationTestsUnitaire;

public class EtatImprimanteEteint extends EtatImprimante {

	public EtatImprimanteEteint(Imprimante imp) {
		super(imp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public EtatImprimante etatsuivant() {
		return new EtatImprimanteAllume(imp);
	}

}
