package game;

public enum Mossa {	
	FORBICE  {
		@Override
		public boolean batte(Mossa other) {
			
			return other == CARTA;
		}
	},	
	CARTA {
		@Override
		public boolean batte(Mossa other){
			return other == PIETRA;
		}
	},
	PIETRA { 
		@Override
		public boolean batte(Mossa other){
			return other == FORBICE;
		} 
	};
	
	public abstract boolean batte(Mossa other);
}
