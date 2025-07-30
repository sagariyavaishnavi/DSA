class LockingTree {
    Map<Integer,Integer> locked;
    List<List<Integer>> child;
    int[] parent;

    public LockingTree(int[] parent) {
        this.locked= new HashMap<>();
        int n=parent.length;
        this.parent=parent;
        this.child = new ArrayList<>();

        for(int i=0; i<n ; i++){
            child.add(new ArrayList<>());
        }
        for(int i=1;i<n ; i++){
            child.get(parent[i]).add(i);
        }
    }
    
    public boolean lock(int num, int user) {
        if(locked.containsKey(num)) return false;
        locked.put(num,user);
        return true;
    }
    
    public boolean unlock(int num, int user) {
        if(!locked.containsKey(num)) return false;
        if(locked.get(num) != user) return false;
        locked.remove(num);
        return true;
    }
    
    public boolean upgrade(int num, int user) {
        if(locked.containsKey(num)) return false;
        if(!haslockedDescendants(num)) return false;
        int curr=num;
        while(curr!=-1){
            if(locked.containsKey(parent[curr])) return false;
            curr=parent[curr];
        }
        unlockAllDescendants(num);
        locked.put(num,user);
        return true;
    }
    private boolean haslockedDescendants(int num)
    {
        for(int c:child.get(num)){
            if(locked.containsKey(c)) return true;
            if(haslockedDescendants(c)) return true;
        }
        return false;
    }
    private void unlockAllDescendants(int num){
        for(int c:child.get(num)){
            if(locked.containsKey(c)){
                locked.remove(c);
            }
            unlockAllDescendants(c);

        }
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */

