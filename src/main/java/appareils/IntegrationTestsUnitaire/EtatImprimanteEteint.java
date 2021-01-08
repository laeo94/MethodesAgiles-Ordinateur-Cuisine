package appareils.IntegrationTestsUnitaire;

public class EtatImprimanteEteint extends EtatImprimante {

	public EtatImprimanteEteint(Imprimante imp) {
		super(imp);
	}

	@Override
	public EtatImprimante etatsuivant() {
		return new EtatImprimanteAllume(imp);
	}

}
