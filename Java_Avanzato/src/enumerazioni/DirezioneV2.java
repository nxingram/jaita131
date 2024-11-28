package enumerazioni;

public enum DirezioneV2 {
	NORD {
		@Override
		public String toString() {
			return "Direzione Nord";
		}
	},
	SUD{
		@Override
		public String toString() {
			return "Direzione Sud";
		}			
	},
	OVEST{
		@Override
		public String toString() {
			return "Direzione Ovest";
		}			
	},
	EST{
		@Override
		public String toString() {
			return "Direzione Est";
		}			
	}
}
