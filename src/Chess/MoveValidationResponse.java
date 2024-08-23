package Chess;

public class MoveValidationResponse {

	int x;
	int y;
	boolean isValid;
	public MoveValidationResponse(int x, int y, boolean isValid) {
		super();
		this.x = x;
		this.y = y;
		this.isValid = isValid;
	}
	
}
