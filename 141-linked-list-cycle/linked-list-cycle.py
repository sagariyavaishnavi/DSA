class Solution:
    def hasCycle(self, head):
        i = head 
        j = head  

        while j and j.next:
            i = i.next      
            j = j.next.next  
            
            if i == j:       
                return True

        return False  