import * as types from "../Constants/ActionTypes";

var initialState = false;

var reducer = (state = initialState, action) => {
  if (action.type === types.SHOW_INPUT_FORM) {
    let isShowInputForm;
    isShowInputForm = !state.isShowInputForm;
    return {
      ...state,
      isShowInputForm: isShowInputForm,
    };
  } else {
    return state;
  }
};
export default reducer;
