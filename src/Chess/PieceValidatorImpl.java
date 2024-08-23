package Chess;

public class PieceValidatorImpl implements MoveValidator {

	@Override
	public MoveValidationResponse isValidMove(PieceType pieceType, int x, int y, int destx, int desty) {

		switch (pieceType) {
		case PAWN:
		case KING:
		case QUEEN:
		case BISHOP:
		case ROOK:
		case KNIGHT:

		}
		return null;
	}

}
