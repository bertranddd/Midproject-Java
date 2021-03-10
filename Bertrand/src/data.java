public class data {
	private String nama;
	private String jeniskelamin;
	private String jabatan;
	private String kode;
	private int urutan;
	// private int gaji;

	public data(String nama, String jeniskelamin, String jabatan, String kode, int urutan) {
		super();
		this.nama = nama;
		this.jeniskelamin = jeniskelamin;
		this.jabatan = jabatan;
		this.kode = kode;
		this.urutan = urutan;
		// this.gaji = gaji;
	}

	public int getUrutan() {
		return urutan;
	}
	public void setUrutan(int urutan) {
		urutan = urutan;
	}

	public String getKode() {
		return kode;
	}

	public void setKode(String kode) {
		this.kode = kode;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
	}

	public void setJeniskelamin(String jeniskelamin) {
		this.jeniskelamin = jeniskelamin;
	}

	public String getNama() {
		return nama;
	}

	public String getJeniskelamin() {
		return jeniskelamin;
	}

	public String getJabatan() {
		return jabatan;
	}

}