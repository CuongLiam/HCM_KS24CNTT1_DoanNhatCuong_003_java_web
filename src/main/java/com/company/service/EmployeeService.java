package com.company.service;

import com.company.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> list = new ArrayList<>();
    private Long id = 1L;

    public List<Employee> findAll() {
        return list;
    }

    public void save(Employee e) {
        e.setId(id++);
        list.add(e);
    }

    public Employee findById(Long id) {
        return list.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }

    public void update(Employee e) {
        delete(e.getId());
        list.add(e);
    }

    public void delete(Long id) {
        list.removeIf(e -> e.getId().equals(id));
    }

    public List<Employee> search(String keyword) {
        if (keyword == null || keyword.isEmpty()) return list;

        return list.stream()
                .filter(e -> e.getFullName().toLowerCase().contains(keyword.toLowerCase())
                        || e.getPosition().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }

    public List<Employee> paginate(List<Employee> data, int page, int size) {
        int start = page * size;
        int end = Math.min(start + size, data.size());

        if (start > data.size()) return new ArrayList<>();

        return data.subList(start, end);
    }
}