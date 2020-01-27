
import java.util.*;

public class Solution<T> {
    
    private List<List<T>> res = new ArrayList<>();
    private boolean canRepeat;

    public Solution(boolean canRepeat){
          this.canRepeat = canRepeat;
    }
	
	//声明一个布尔数组，用来判断某个索引位置的数字是否被使用过了
	private boolean[] used;
	
    public List<List<T>> permute(T[] nums) {
		if (nums.length == 0) {
			return res;
		}
		
		used = new boolean[nums.length];
		List<T> preList = new ArrayList<>();
		generatePermutation(nums, 0, preList);
		
		return res;

	}

	/**
	 * 回溯
	 * @param nums 给定数组
	 * @param index 当前考察的索引位置
	 * @param preList 先前排列好的子序列
	 */
	private void generatePermutation(T[] nums,int index,List<T> preList) {
		//index 等于给定数组的长度时，说明一种排列已经形成，直接将其加入成员变量 res 里
		if (index == nums.length) {
			//这里需要注意java的值传递
			//此处必须使用重新创建对象的形式，否则 res 列表中存放的都是同一个引用
			res.add(new ArrayList<>(preList));
			return;
		}
		
		for(int i = 0; i < nums.length ;i++) {
			if (!used[i]) {
				preList.add(nums[i]);
                                if(!canRepeat){
				  used[i] = true;
                                }
				generatePermutation(nums, index + 1, preList);
				//一定要记得回溯状态
				preList.remove(preList.size() - 1);
                                if(!canRepeat){
				  used[i] = false;
                                }   
			}
		}
        return;
	}	
}
