package appareils.IntegrationTestsUnitaire;

public class EtatImprimanteEteint extends EtatImprimante {

	public EtatImprimanteEteint(Imprimante imp) {
		super(imp);
	}

	@Override
	public EtatImprimante etatSuivant() {
		return new EtatImprimanteAllume(imp);
	}

}
