import { useNavigate } from "react-router-dom";

export const MyReview = () => {
  const navigate = useNavigate();
  return (
    <div className="modalDiv">
      <div className="modal">
      <p style={{textAlign: "center", fontSize: 40}}>내가 쓴 리뷰</p>
        <button onClick={() => navigate(-1)}>Close</button>
      </div>
    </div>
  );
};