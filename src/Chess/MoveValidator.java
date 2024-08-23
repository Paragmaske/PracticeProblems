package Chess;

public interface MoveValidator {

   MoveValidationResponse isValidMove(PieceType pieceType,int srcx ,int srcy,int destx,int desty);
}
