package appareils.IntegrationTestsUnitaire;

public class EtatImprimanteAllume extends EtatImprimante {

	public EtatImprimanteAllume(Imprimante imp) {
		super(imp);
	}

	@Override
	public EtatImprimante etatSuivant() {
		return new EtatImprimanteEteint(imp);
	}

}
