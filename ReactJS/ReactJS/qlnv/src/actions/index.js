import * as types from '../constants/ActionTypes';
 
// export viết dưới dạng hàm
export const get_list_accounts = () =>{
    return {
        type : types.GET_LIST_ACCOUNTS // type không đổi nên không cần truyền từ bên ngoài
        
    }
}
