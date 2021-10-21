import React from "react";
import { useState, useEffect } from "react";

function Hook4() {
  const [Count1, setCount1] = useState(0);
  const [Count2, setCount2] = useState(0);
  // Trường hợp 1: thay thế cho componentdidmount, componentdidupdate
  // Mỗi khi click chuột thì giá trị Count tăng lên 1 đơn vị ==> State thay đổi, chương trình reRender lại ==> useEffect này được thực thi.
  useEffect(() => {
    console.log("useEffect thực thi khi nhấn button 1.");
    return () => {
      // Phần này sẽ thay thế cho component componentwillunmount
      console.log("Thực hiện nội dung cho componentwillunmount");
    };
  }, [Count1]);
  // Tạo thêm useEffect tương ứng với button2.
  useEffect(() => {
    console.log("useEffect thực thi khi nhấn button 2.");
  }, []);

  return (
    <div className="row">
      <div className="col-xs-6 col-sm-6 col-md-6 col-lg-6">
        <button
          type="button"
          className="btn btn-success"
          onClick={() => setCount1(Count1 + 1)}
        >
          Button1
        </button>
        <br />
        <button
          type="button"
          className="btn btn-success"
          onClick={() => setCount2(Count2 + 1)}
        >
          Button2
        </button>
      </div>
      <div className="col-xs-6 col-sm-6 col-md-6 col-lg-6">
        <p style={{ fontSize: "50" }}>Bạn đã click {Count1} lần vào button1.</p>
        <p style={{ fontSize: "50" }}>Bạn đã click {Count2} lần vào button2.</p>
      </div>
    </div>
  );
}
export default Hook4;
