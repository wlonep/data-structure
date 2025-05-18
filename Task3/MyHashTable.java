package Task3;

import java.util.ArrayList;

public class MyHashTable {
    private ArrayList<ArrayList<StudentInfo>> bucketArray;
    private int bucketCapacity;
    private float loadFactor;

    MyHashTable(int initialCapacity) {
        this(initialCapacity, 0.75f);
    }

    MyHashTable(int initialCapacity, float loadFactor) {
        this.bucketCapacity = initialCapacity;
        this.loadFactor = loadFactor;
        this.bucketArray = new ArrayList<>(bucketCapacity);
        for (int i = 0; i < bucketCapacity; i++) {
            bucketArray.add(new ArrayList<>());
        }
    }

    public int hashFunc(String k) {
        int a = 33;
        int hashVal = 0;
        for (int i = 0; i < k.length(); i++) {
            hashVal = (hashVal * a + k.charAt(i)) % bucketCapacity;
        }
        return hashVal;
    }

    private void rehash(int newCapacity) {
        ArrayList<ArrayList<StudentInfo>> oldBucketArray = bucketArray;
        bucketCapacity = newCapacity;
        bucketArray = new ArrayList<>(bucketCapacity);
        for (int i = 0; i < bucketCapacity; i++) {
            bucketArray.add(new ArrayList<>());
        }
        for (ArrayList<StudentInfo> bucket : oldBucketArray) {
            for (StudentInfo info : bucket) {
                int index = hashFunc(info.getStudentID());
                bucketArray.get(index).add(info);
            }
        }
    }

    public float getLoadFactor() {
        int total = 0;
        for (ArrayList<StudentInfo> bucket : bucketArray) {
            total += bucket.size();
        }
        return (float) total / bucketCapacity;
    }

    public int size() {
        int size = 0;
        for (ArrayList<StudentInfo> bucket : bucketArray) {
            size += bucket.size();
        }
        return size;
    }

    public String get(String k) {
        int index = hashFunc(k);
        for (StudentInfo student : bucketArray.get(index)) {
            if (student.getStudentID().equals(k)) {
                return student.getStudentName();
            }
        }
        return null;
    }

    public String put(String k, String v) {
        int index = hashFunc(k);
        for (StudentInfo student : bucketArray.get(index)) {
            if (student.getStudentID().equals(k)) {
                String oldName = student.getStudentName();
                student.setStudentName(v);
                return oldName;
            }
        }
        StudentInfo newStudent = new StudentInfo();
        newStudent.setStudentID(k);
        newStudent.setStudentName(v);
        bucketArray.get(index).add(newStudent);
        return null;
    }

    public String remove(String k) {
        int index = hashFunc(k);
        ArrayList<StudentInfo> bucket = bucketArray.get(index);
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).getStudentID().equals(k)) {
                String removedName = bucket.get(i).getStudentName();
                bucket.remove(i);
                return removedName;
            }
        }
        return null;
    }

    public void printTable() {
        for (int i = 0; i < bucketCapacity; i++) {
            for (StudentInfo student : bucketArray.get(i)) {
                System.out.print(hashFunc(student.getStudentID()) + ": " + student.getStudentID() + " ");
            }
            System.out.println();
        }
    }
}
