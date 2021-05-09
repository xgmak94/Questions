class Solution(object):
    def twoSum(self, nums, target):
        if len(nums) <= 1:
            return False
        buff_dict = {}
        for i in range(len(nums)):
            if nums[i] in buff_dict:
                return [buff_dict[nums[i]], i]
            else:
                buff_dict[target - nums[i]] = i

solution = Solution()
print(Solution.twoSum(solution, [2,7,11,15], 9))
print(Solution.twoSum(solution, [3,2,4], 6))
print(Solution.twoSum(solution, [3,3], 6))
