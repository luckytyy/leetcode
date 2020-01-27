
import java.util.*;

public class Solution<T> {
    
    private List<List<T>> res = new ArrayList<>();
    private boolean canRepeat;

    public Solution(boolean canRepeat){
          this.canRepeat = canRepeat;
    }
	
	//����һ���������飬�����ж�ĳ������λ�õ������Ƿ�ʹ�ù���
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
	 * ����
	 * @param nums ��������
	 * @param index ��ǰ���������λ��
	 * @param preList ��ǰ���кõ�������
	 */
	private void generatePermutation(T[] nums,int index,List<T> preList) {
		//index ���ڸ�������ĳ���ʱ��˵��һ�������Ѿ��γɣ�ֱ�ӽ�������Ա���� res ��
		if (index == nums.length) {
			//������Ҫע��java��ֵ����
			//�˴�����ʹ�����´����������ʽ������ res �б��д�ŵĶ���ͬһ������
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
				//һ��Ҫ�ǵû���״̬
				preList.remove(preList.size() - 1);
                                if(!canRepeat){
				  used[i] = false;
                                }   
			}
		}
        return;
	}	
}
