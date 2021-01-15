package appareils.IntegrationTestsUnitaire;

public abstract class EtatImprimante {
	public Imprimante imp;

	public EtatImprimante(Imprimante imp) {
		this.imp = imp;
	}

	public abstract EtatImprimante etatSuivant();
}
