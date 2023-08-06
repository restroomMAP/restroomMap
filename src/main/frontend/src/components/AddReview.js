import { useNavigate } from "react-router-dom";
import React from "react";
import { useState } from "react";
import axios from "axios";


export const AddReview = () => {

  let navigate = useNavigate();

  const [review, setReview]=useState({
    stars:"",
    detailedReview:"",
    // reviewKeywords:""
  })

  const {stars, detailedReview}=review

  const onInputChange=(e) => {
    setReview({ ...review,[e.target.name]: e.target.value})
  }

  const onSubmit =async (e) => {
    e.preventDefault();
    await axios.post("http://localhost:8080/reviews",review)
    navigate("/")   //나중에 화장실에 관한 리뷰목록 url로 바꾸기. 현재는 home으로
  }

  return (
      <div className="modalDiv">
          <div className="modal">

              <p style={{textAlign: "center", fontSize: 40}}>후기 등록</p>

                  <form onSubmit={(e)=>onSubmit(e)}>
                      <div className="mb-3">
                          <label htmlFor="stars" className="form-label">
                            별점
                          </label>
                          <input
                          name="stars"
                          value={stars}
                          onChange={(e)=>onInputChange(e)}
                          />
                      </div>

                      <div className="mb-3">
                          <label htmlFor="detailedReview" className="form-label">
                            상세후기
                          </label>
                          <textarea
                          name="detailedReview"
                          value={detailedReview}
                          onChange={(e)=>onInputChange(e)}
                          rows="15" cols="50"></textarea>
                      </div>


{/* 
                      <div className="mb-3">
                          <label htmlFor="reviewKeywords" className="form-label">
                            키워드
                          </label>
                          <input
                          name="reviewKeywords"
                          value={reviewKeywords}
                          onChange={(e)=>onInputChange(e)}
                          />
                      </div> */}


                      <button type="submit">등록</button>
                  </form>

            <button onClick={() => navigate(-1)}>Close</button>

          </div>
      </div>
  );
};